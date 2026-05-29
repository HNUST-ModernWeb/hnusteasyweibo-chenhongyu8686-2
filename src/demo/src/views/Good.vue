<template>
  <div>
    <h3>商品列表</h3>
    <ul>
      <li v-for="(item, i) in list" :key="i">{{ item }}</li>
    </ul>
    <button @click="handleLike">点赞</button>
    <p>点赞数：{{ likeCount }}</p>
  </div>
    <div @scroll="handleScroll" style="height:300px;overflow:auto">
    <li v-for="(item,i) in list" :key="i">{{ item }}</li>
    <p v-if="loading">加载中...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import request from '@/utils/request'

const list = ref([])
const likeCount = ref(0)

// 1. 页面加载自动请求
onMounted(() => {
  getList()
})

// 获取列表
async function getList() {
  const res = await request.get('/api/goods/list')
  if (res.code === 200) {
    list.value = res.data
  }
}

// 点赞
async function handleLike() {
 // 点赞点击事件
const handleLike = async () => {
  try {
    // 用反引号，格式完全匹配后端路径
    const res = await request.post(`/api/goods/like/1`)
    if (res.code === 200) {
      likeCount.value = res.data
    }
  } catch (error) {
    console.log("点赞失败", error)
  }
}

}
let timer = null

// 定时刷新（5秒一次）
function startRefresh() {
  timer = setInterval(() => {
    getList()
  }, 5000)
}

function stopRefresh() {
  clearInterval(timer)
}

onMounted(() => {
  getList()
  startRefresh()
})

// 组件销毁时清除
onUnmounted(() => {
  stopRefresh()
})
const cache = new Map()

async function getList() {
  const key = 'goodsList'
  if (cache.has(key)) {
    list.value = cache.get(key)
    return
  }
  const res = await request.get('/api/goods/list')
  if (res.code === 200) {
    list.value = res.data
    cache.set(key, res.data) // 缓存
  }
}
const loading = ref(false)
let page = 1

async function loadMore() {
  loading.value = true
  // 模拟分页请求
  const res = await request.get(`/api/goods/list?page=${page}`)
  list.value.push(...res.data)
  page++
  loading.value = false
}

function handleScroll(e) {
  const { scrollTop, scrollHeight, clientHeight } = e.target
  if (scrollTop + clientHeight >= scrollHeight - 10) {
    loadMore()
  }
}
</script>
<button @click="getList">手动刷新</button>