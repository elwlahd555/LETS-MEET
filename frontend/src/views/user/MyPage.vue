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
              <!-- 친구추가 팝업창 -->
               <v-dialog
                  v-model="dialog"
                  persistent
                  max-width="290"
                  >
                  
                  <template v-slot:activator="{ on, attrs }">
                    <div class='text-center' v-bind="attrs" v-on="on">
                      <h5><v-icon>mdi-plus-circle</v-icon>&nbsp; 친구 추가</h5>
                    </div>
                  </template>
                  <v-card>
                    <v-card-title class="headline">
                      친구 추가
                    </v-card-title>
                    <v-card-text>이메일 혹은 이름을 입력해주세요.</v-card-text>
                    
                    <v-card-text>

                      <!-- <div id="autocomplete" class="autocomplete">
                        <input class="autocomplete-input" v-model='addFriend' @keyup="checkFriend"
                          placeholder="Search for a country"
                          aria-label="Search for a country"
                        >
                        <ul class="autocomplete-result-list"></ul>
                        <ul id="no-results" class="autocomplete-result-list" visible="false">
                          <li class="autocomplete-result">
                            No results found
                          </li>
                        </ul>
                      </div> -->
                      <v-text-field
                      v-model="addFriend"
                      @keypress.enter="searchUserData"
                      append-icon="mdi-magnify"
                      single-line
                      hide-details
                      >
                      </v-text-field>
                      </v-card-text>
                      
                      <div v-if="showNoResults === false">
                        <ul v-for="(friend, i) in searchFriendList" :key="i">
                          <li @click="addMyFriendList">{{friend.uName}}&nbsp;&nbsp; {{friend.uEmail}}</li>
                        </ul>
                      </div>

                      <div v-else>
                        <div> 결과 정보가 없습니다.</div>
                      </div>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        color="green darken-1"
                        text
                        @click="dialog = false"
                      >
                        취소
                      </v-btn>
                      <v-btn
                        color="green darken-1"
                        text
                        @click="dialog = false"
                      >
                        확인
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>



              <div class='p-2' v-for="friend in friends" :key="friend">
                <div>
                  <v-avatar>
                    <img
                      src="https://cdn.vuetifyjs.com/images/john.jpg"
                      alt="John"
                    >
                  </v-avatar>
                  {{ friend }}
                  <div class="d-inline-flex" @click="deleteFriend"><v-icon>mdi-letter-x-circle-outline</v-icon></div>
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
const axios = require('axios');
const config = {
          headers: { 'auth-token': window.localStorage.getItem('auth-token') },
      }
import MypageLikePlace from "../../components/user/mypage/MypageLikePlace"

export default {
    name: 'MyPage',
    components: {
      MypageLikePlace
    },
    created: () => {
      // 친구목록 조회
        axios.get(`http://localhost:8000/letsmeet/mypage/friend/`, config)
          .then((res)=> {
            console.log(res.data)
          })
          .catch(()=> {
            console.log('data 못받아옴')
          })
    },
    methods: {
      addMyFriendList () {
        //친구 추가 
      },
      deleteFriend () {
        // 친구 삭제
      },
      searchUserData() {
        if (this.addFriend.length > 0) {
          axios.get(`http://localhost:8000/letsmeet/mypage/friend/search`, this.addFriend, config)
          .then((res)=> {
            console.log(res.data)
            // // 비어 있지않을 때

            // this.searchFriendList = res.data

            // // 비어 있을 때 보여줄 list
            // this.showNoResults = !this.showNoResults
      
          })
          .catch(()=> {
          })
        } else{
          // this.searchFriendList = []
        }
      },

      logout () {
        this.$store.dispatch('LOGOUT')
        .then(()=> {
          this.$router.replace({ name: 'Login'})
        })
      }
    },
    mounted() { 
      this.uEmail = this.$store.state.uEmail
      this.uName= this.$store.state.uName
    },
    data: () => {
      return {
        tab: null,
        addFriend: '',
        searchFriendList: [],
        showNoResults: false,
        dialog: false,
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
  #autocomplete {
  max-width: 400px;
  margin: 0 auto;
}
  #no-results {
    display: none;
    position: absolute;
    z-index: 1;
    width: 100%;
    top: 100%;
  }

  .no-results #no-results {
    display: block;
  }

  .no-results .autocomplete-input.focused {
    border-bottom-color: transparent;
    border-radius: 8px 8px 0 0;
  }

  .no-results .autocomplete-input:not(.focused) ~ #no-results {
    display: none;
  }
</style>