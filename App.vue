<template>
  <div class="container">
    <!-- 顶部导航 -->
    <div class="nav">
      <router-link to="/">首页</router-link>
      <router-link to="/publish">发布</router-link>
      <router-link to="/profile">我的</router-link>
    </div>

    <!-- 页面内容路由出口 -->
    <router-view />
  </div>
</template>

<script setup>
// 后续表单、交互特效的JS代码都写在这里
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
.container {
  width: 1200px;
  margin: 30px auto;
}
.nav {
  display: flex;
  gap: 20px;
  margin-bottom: 30px;
}
.nav a {
  text-decoration: none;
  color: white;
  padding: 6px 12px;
  background: #42b983;
  border-radius: 5px;
}
.nav a:hover {
  opacity: 0.9;
}
</style>