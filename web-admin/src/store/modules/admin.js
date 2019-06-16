import { login, logout, getInfo } from '@/api/admin/login'
import { getToken, setToken, removeToken } from '@/utils/auth'
import router, { resetRouter } from '@/router'
import store from "../index";

const state = {
  token: getToken(),
  name: '',
  avatar: '',
  introduction: '',
  roles: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, data) => {
    state.roles = data
  }
}

const actions = {

  //管理员登录
  login({ commit }, userInfo) {
    const { accessNum, password } = userInfo
    return new Promise((resolve, reject) => {
      login({ accessNum: accessNum, password: password }).then(response => {
        console.log(response)
        const { data } = response
        console.log("获取到的token："+data.token)
        commit('SET_TOKEN', data.token)
        setToken(data.token)
        console.log("当前的token值是："+state.token)
        resolve()
      }).catch(error => {
        console.log("reject")
        console.log(error)
        reject(error)
      })
    })
  },

  // 管理员信息
  getInfo({ commit, state }) {
  return new Promise((resolve, reject) => {
    getInfo(state.token).then(response => {
      const { data } = response
      console.log("admin info :"+response.data.roles)
      console.log("admin info :"+response)
      if (!data) {
        reject('Verification failed, please Login again.')
      }

      console.log("用户信息"+data)
      const { roles, name, avatar, introduction } = data

      // roles must be a non-empty array
      if (!roles || roles.length <= 0) {
        reject('getInfo: roles must be a non-null array!')
      }
      console.log("roles is :"+roles)
      commit('SET_ROLES', new Array("admin","editor"))
      console.log("roles :::"+store.getters.roles)
      commit('SET_NAME', name)
      commit('SET_AVATAR', avatar)
      commit('SET_INTRODUCTION', "super admin")

      console.log("name :::"+store.getters.name)
      console.log("avatar :::"+store.getters.avatar)
      console.log("introduction :::"+store.getters.introduction)
      resolve(data)
    }).catch(error => {
      reject(error)
    })
  })
},

// user logout
logout({ commit, state }) {
  return new Promise((resolve, reject) => {
    logout(state.token).then(() => {
      commit('SET_TOKEN', '')
      commit('SET_ROLES', [])
      removeToken()
      resetRouter()
      resolve()
    }).catch(error => {
      reject(error)
    })
  })
},

// remove token
resetToken({ commit }) {
  return new Promise(resolve => {
    commit('SET_TOKEN', '')
    commit('SET_ROLES', [])
    removeToken()
    resolve()
  })
},

// dynamically modify permissions
changeRoles({ commit, dispatch }, role) {
  return new Promise(async resolve => {
    const token = role + '-token'

    commit('SET_TOKEN', token)
    setToken(token)

    const { roles } = await dispatch('getInfo')

    resetRouter()

    // generate accessible routes map based on roles
    const accessRoutes = await dispatch('permission/generateRoutes', roles, { root: true })

    // dynamically add accessible routes
    router.addRoutes(accessRoutes)

    resolve()
  })
}


}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
