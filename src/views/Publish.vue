<template>
  <div>
    <h2>发布动态</h2>
    <textarea v-model="content" placeholder="分享你的想法..."></textarea>
    <button @click="publish">发布</button>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()

// 响应式数据
const content = ref('')

// 发布方法
const publish = () => {
  if (!content.value.trim()) {
    alert('请输入内容')
    return
  }
  alert('发布成功！')
  router.push('/') // 跳回首页
}
</script>

<style scoped>
textarea {
  width: 100%;
  height: 140px;
  padding: 12px;
  margin: 15px 0;
  border-radius: 8px;
  border: 1px solid #ddd;
}
button {
  padding: 10px 16px;
  background: #42b983;
  color: white;
  border: none;
  border-radius: 6px;
}
</style>