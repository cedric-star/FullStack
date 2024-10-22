import { createRouter, createWebHistory } from 'vue-router'
import GameMain from "@/components/GameMain.vue"
import loginWindow from "@/components/loginWindow.vue";
import HomePage from '@/components/Home.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'HomePage',
            component: HomePage
        },
        {
            path: '/game',
            name: 'GameMain',
            component: GameMain
        },
        {
            path: '/login',
            name: 'login',
            component: loginWindow
        }
    ]
})

export default router
