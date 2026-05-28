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