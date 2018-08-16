import axios from 'axios'
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 20000, // request timeout
  responseType: 'json',
  transformRequest: [
    data => (typeof (data) !== 'object') ? data : qs.stringify(data)
  ]
})
export default service
