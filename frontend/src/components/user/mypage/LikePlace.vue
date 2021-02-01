<template>
    <div class="p-3">
        <div v-for="(place, i) in likeplacelist" :key="i">
            <v-card class="mb-3">
              <!-- 카드 눌렀을때 이동이 가능하게 할 것인가? -->
                <v-img class='d-flex align-end'
                  height="200"
                  src="https://cdn.vuetifyjs.com/images/cards/cooking.png"
                >
                  <div class="d-flex justify-end m-1">
                    <v-icon color="pink accent-2">mdi-heart</v-icon>
                  </div>
                </v-img>
                <v-card-title>{{ place.name }} </v-card-title>
                <v-card-text>
                  {{ place.content }}
                </v-card-text>
                
            </v-card>
        </div>
    </div>
</template>
<script>
export default {
    name: 'LikePlace',
    data: () => {
        return {
            likeplacelist: [
                { name: '윤식당', content: '맛나' }, 
                { name: '주식당', content: '아맛나'}, 
                { name: '민식당', content: '아아맛나'}
            ],
        }
    }
}
</script>