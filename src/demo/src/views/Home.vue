<template>
  <div>
    <h2>动态信息流</h2>
    <div class="card" v-for="item in postList" :key="item.id">
      <h4>{{ item.username }}</h4>
      <p>{{ item.content }}</p>
      <button>点赞</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'

// 模拟数据（前端状态管理）
const postList = ref([
  { id: 1, username: '小明', content: '今天学会了 Vue3 组件！' },
  { id: 2, username: '小红', content: 'VS Code + Vue 开发太爽了' }
])
</script>

<style scoped>
.card {
  border: 1px solid #eee;
  padding: 18px;
  margin: 12px 0;
  border-radius: 10px;
}
h4 { margin-bottom: 8px; }
button { margin-top: 10px; padding: 6px 12px; background: #42b983; color: #fff; border: none; border-radius: 6px; }
</style>
<script setup>
// 1. 从vue引入：ref(定义响应式数组)、onMounted(页面加载完成自动执行)
import { ref, onMounted } from 'vue'
// 2. 导入刚才封装好的axios请求工具
import request from '@/utils/request'

// 3. 定义响应式列表，后端数据放这里，页面自动渲染更新
const list = ref([])

// 4. 封装加载数据的函数：异步请求后端接口
const loadList = async () => {
  // 调用后端 GET 接口 /api/goods/list，拿到数据赋值给list
  list.value = await request.get('/api/goods/list')
}

// 5. 页面一打开，就自动调用函数，拉取后端数据
onMounted(loadList)
let cache = null, lastTime = 0
const loadList = async () => {
  const now = Date.now()
  // 5分钟内用缓存
  if (cache && now - lastTime < 5 * 60 * 1000) {
    list.value = cache
    return
  }
  list.value = await request.get('/api/goods/list')
  cache = list.value
  lastTime = now
}
onMounted(() => {
  loadList()
  setInterval(loadList, 5000) // 每5秒刷新一次
})
<button @click="loadList">刷新数据</button>
<button @click="likeItem(item.id)">
  👍 {{ item.likeCount }}
</button>

<script setup>
const likeItem = async (id) => {
  const count = await request.post(`/api/goods/like/${id}`)
  item.likeCount = count
}
</script>
router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')
  if (to.meta.requireAuth && !token) {
    next('/login')
  } else {
    next()
  }
})
