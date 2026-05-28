<template>
  <!-- 导航栏 -->
  <nav>
    <router-link to="/">首页</router-link>
    <router-link to="/publish">发布</router-link>
    <router-link to="/profile">我的</router-link>
  </nav>

  <!-- 路由页面展示 -->
  <div class="container">
    <router-view />
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
nav {
  text-align: center;
  padding: 16px;
  background: #f5f5f5;
  margin-bottom: 20px;
}
nav a {
  margin: 0 12px;
  text-decoration: none;
  color: #333;
}
nav a:hover {
  color: #42b983;
}
.container {
  max-width: 700px;
  margin: 0 auto;
  padding: 0 20px;
}
</style>