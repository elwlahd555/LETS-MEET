<template>
    <div>
      <div class='userinfo'>
          <div class='justify-center' style="border-bottom: 2px solid black">
              <h5> 마이페이지 </h5>
          </div>
              <!-- 톱니바퀴 -->
              <div class='justify-end'>
              <v-menu
                  left
                  bottom
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-btn
                      icon
                      style="color: black;"
                      v-bind="attrs"
                      v-on="on"
                    >
                        <v-icon color="indigo accent-2" >mdi-cog</v-icon>
                      <!-- <v-icon>mdi-dots-vertical</v-icon> -->
                    </v-btn>
                  </template>

                  <v-list>
                    <v-list-item>
                      <v-list-item-title> <router-link class="ro" :to="{ name: 'UserInfoChange' }"> 회원정보 수정 </router-link></v-list-item-title>
                    </v-list-item>
                    <v-list-item @click="logout">
                      <v-list-item-title> 로그아웃 </v-list-item-title>
                    </v-list-item>
                  </v-list>
                </v-menu>
              </div>

          <!-- 유저정보 -->
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
                <div> {{uName}} </div>
                <div> {{uEmail}} </div>
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
              <div class='p-2' v-for="friend in friends" :key="friend">
                <div>
                  <v-avatar>
                    <img
                      src="https://cdn.vuetifyjs.com/images/john.jpg"
                      alt="John"
                    >
                  </v-avatar>
                  {{ friend }}
                  <div class="d-inline-flex"><v-icon>mdi-letter-x-circle-outline</v-icon></div>
                </div>
              </div>
            </div>
          </v-tab-item>

          <v-tab-item>
            <v-card>
              <!-- 좋아하는 장소 -->
              <MypageLikePlace />
            </v-card>
          </v-tab-item>
        </v-tabs-items>
    </div>
</template>
<script>
import MypageLikePlace from "../../components/user/mypage/MypageLikePlace"

export default {
    name: 'MyPage',
    components: {
      MypageLikePlace
    },
    methods: {
      logout () {
        this.$store.dispatch('LOGOUT')
        .then(()=> {
          this.$router.replace({ name: 'Login'})
        })
      }
    },
    // computed: {
    //   ...mapGetters([
    //     'get_user_email',
    //     'get_user_name'
    //   ])
    // },
    mounted() { 
      this.uEmail = this.$store.state.uEmail
      this.uName= this.$store.state.uName
    },
    data: () => {
      return {
        tab: null,
        uEmail: '',
        uName: '',
        items: [
          '친구목록',
          '찜한 장소'
        ],
        friends: [
          '지현', '동빈', '성헌', '주이', '호빈'
        ],
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
  .ro {
    text-decoration: none !important;
    color: inherit !important;
  }
</style>