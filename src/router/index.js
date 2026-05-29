import { createRouter, createWebHistory } from 'vue-router'
import Home from '../demo/src/views/Home.vue'
import Publish from '../demo/src/views/Publish.vue'
import Profile from '../demo/src/views/Profile.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/publish', component: Publish },
  { path: '/profile', component: Profile }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router