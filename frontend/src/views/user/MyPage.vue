<template>
    <div>
      <div class='userinfo'>
          <div class='justify-center' style="border-bottom: 2px solid black">
              <h5> 마이페이지 </h5>
          </div>
          <div class='justify-end'>
            <v-icon color="indigo accent-2">mdi-cog</v-icon>
          </div>
          <v-container class='pt-5'>
            <v-row>
              <v-col
                class="account"
                cols='2'>
                <v-avatar>
                    <img
                      src="https://cdn.vuetifyjs.com/images/john.jpg"
                      alt="John"
                    >
                </v-avatar>
              </v-col>
              <v-col>
                <div>username</div>
                <div>email</div>
              </v-col>
            </v-row>
          </v-container>
        </div>
        
      <hr class='m-0'>
        <v-tabs
          v-model="tab"
          background-color="indigo accent-2"
          dark
          grow
        >
        <v-tab
          v-for='item in items'
          :key='item'
        >
          {{ item }}
        </v-tab>
        </v-tabs>

        <v-tabs-items v-model="tab"> 
          <v-tab-item>
            <div class= 'p-3'>
              <div class='text-center'>
                <h5><v-icon>mdi-plus-circle</v-icon>&nbsp; 친구 추가</h5>
              </div>

              <div class='d-flex p-2' v-for="friend in friends" :key="friend">
                <div class='row'>
                  <div class='col-2'>
                    <v-avatar>
                      <img
                        src="https://cdn.vuetifyjs.com/images/john.jpg"
                        alt="John"
                      >
                    </v-avatar>
                  </div>
                  <div class='col-8 d-flex align-items-center'>
                    {{ friend }}
                  </div>
                  <div class='col d-flex align-middle'>
                    <v-icon @click="delete_friend">mdi-roman-numeral-10</v-icon>
                  </div>
                </div>
              </div>
            </div>
          </v-tab-item>

          <v-tab-item>
            <LikePlace />
          </v-tab-item>
        </v-tabs-items>
    </div>
</template>
<script>
import LikePlace from '../../components/user/mypage/LikePlace.vue'

export default {
    name: 'MyPage',
    components: {
      LikePlace
    },
    data: () => {
      return {
        tab: null,
        items: [
          '친구목록',
          '찜한 장소'
        ],
        friends: [
          '지현', '동빈', '성헌', '주이', '호빈'
        ],
      }
    },
    methods: {
      delete_friend() {
        console.log('not yet')
      }
    }
}
</script>
<style scoped>
  .userinfo > div {
    display: flex;
    margin: 20px;
  }
  .account {
    padding-left:25px;
  }
</style>