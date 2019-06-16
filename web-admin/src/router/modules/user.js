/** 用户管理 **/

import Layout from '@/layout'

const userRouter = {
  path: '/user',
  component: Layout,
  redirect: '/user/userAnalyse',
  name: 'user',
  meta: {
    title: '用户管理',
    icon: 'manage',
    roles: ['admin', 'editor']
  },
  children: [
    {
      path: 'userManage',
      component: () => import('@/views/user/components/manage/complex-table'),
      name: '用户管理',
      meta: {
        title: '用户管理',
        noCache: true,
        roles: ['admin', 'editor']
      }
    },
    {
      path: 'userAnalyse',
      component: () => import('@/views/user/components/analyse/index'),
      name: '用户分析',
      meta: {
        title: '用户分析',
        noCache: true ,
        roles: ['admin', 'editor']
      }
    },
  ]
}

export default userRouter
