import axios from 'axios'

import config from '../config'

const axiosInstance = axios.create({
  baseURL: config.apiUrl,
  timeout: 5000
})

/*
axiosInstance.interceptors.request.use((config) => {
  config.headers = {
    ...(config.headers === undefined ? {} : config.headers),
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  }

  return config
})
*/

export default axiosInstance
