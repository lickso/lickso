// import { fetch } from '@/utils/request'
import request from '@/utils/request'

/*管理员登录*/
export function login(data) {
  return request({
    url: '/admin/login',
    method: 'post',
    data
  })
}

/*管理员信息*/
export function getInfo(token) {
  return request({
    url: '/admin/info',
    method: 'get',
    params: { token }
  })
}


// /*管理员登录*/
// export function login(params) {
//   return fetch({
//     url: '/admin/login',
//     method: 'POST',
//     params: params
//   })
// }

// export function getInfo(token) {
//   return request({
//     url: '/admin/info',
//     method: 'get',
//     params: { token }
//   })
// }
//
// export function logout() {
//   return request({
//     url: '/admin/logout',
//     method: 'post'
//   })
// }

