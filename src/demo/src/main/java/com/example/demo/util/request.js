import axios from 'axios'

const request = axios.create({
  baseURL: 'http://localhost:8080', // 后端端口
  timeout: 10000
})

// 请求拦截器（统一加token）
request.interceptors.request.use(config => {
  const token = localStorage.getItem('token')
  if (token) config.headers.Authorization = `Bearer ${token}`
  return config
})

// 响应拦截器（统一处理成功/失败）
request.interceptors.response.use(
  res => res.data, // 直接返回 data
  err => {
    console.error('请求错误：', err)
    return Promise.reject(err)
  }
)

export default request
request.interceptors.request.use(config => {
  const token = localStorage.getItem('token')
  if (token) {
    config.headers.Authorization = 'Bearer ' + token
  }
  return config
})