<template>
    <div class='p-3'>
        <v-card v-for='(place, i) in likeplace' :key='i' class='mb-2'>
            <v-img
            @click="placeDetail"
            class= 'd-flex align-end'
            height="200"
            src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
            >
            <div class='d-flex justify-end'>
                <v-icon color="red">mdi-heart</v-icon>
            </div>
            </v-img>
            <v-card-title>
                {{place.name}}
            </v-card-title>
            <v-card-text>
                {{place.content}}
            </v-card-text>
        </v-card>
    </div>
</template>
<script>
const axios = require('axios')
export default {
    name: 'MypageLikePlace',
    data: () => {
        return {
            likeplace: [
                { name: '주이집', content: '한식 맛집'},
                { name: '성헌집', content: '중식 맛집'},
                { name: '동빈집', content: '양식 맛집'},
                { name: '지현집', content: '일식 맛집'},
                { name: '호빈집', content: '다 맛집'}
            ] 
        }
    },
    mounted() {
        this.getLikeStore()
    },
    methods: {
        getLikeStore () {
            axios.get(`http://localhost:8000/letsmeet/mypage/likestore?uNo=${this.$store.state.uNo}`)
            .then((res)=> {
                // 가게 상세 조회 detail db 만들어져야함
                console.log(res.data)
            })
            .catch(()=> {
                console.log('안됨/')
            })
        },
        placeDetail () {
            console.log('이미지 클릭')

        }
    }
}
</script>