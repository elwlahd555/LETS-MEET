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
            <div class='p-3'>
              
              <!-- 친구추가 팝업창 -->
               <v-dialog
                  v-model="dialog"
                  persistent
                  max-width="90%"
                  >
                  
                  <template v-slot:activator="{ on, attrs }">
                    <div class='text-center' v-bind="attrs" v-on="on">
                      <h5><v-icon>mdi-plus-circle</v-icon>&nbsp; 친구 추가</h5>
                    </div>
                  </template>
                  <v-card>
                    <h4 class="p-3 text-center">
                      친구 추가
                    </h4>


                    <v-container v-if="tmplist.length > 0" class="p-3">
                      <div>
                        <v-container>
                          <v-row>
                            <v-col cols='3' v-for="(friend, i) in tmplist" :key="i">
                              <v-row>
                                <v-col class="d-flex align-center p-1">
                                <v-avatar  style="text-center">
                                  <img
                                    src="https://cdn.vuetifyjs.com/images/john.jpg"
                                    alt="John"
                                  >
                                </v-avatar>
                                </v-col>
                              </v-row>
                              <v-row class="d-flex align-center" style="text-center font-size: 0.9rem;">
                                <v-col cols='6' class="d-flex align-center p-0">{{ friend[1] }} </v-col>
                                <v-col class="d-flex-inline align-center p-0" cols='2'><v-icon @click="deleteTemporaryList(i)">mdi-close-circle-outline</v-icon></v-col>
                              </v-row>
                            </v-col>
                          </v-row>
                        </v-container>
                      </div>
                    </v-container>

                    

                    <v-card-text>
                      <v-text-field
                      v-model="addFriend"
                      placeholder="이메일 혹은 이름을 입력해주세요."
                      @keypress.enter="searchUserData"
                      @click="searchUserData"
                      append-icon="mdi-magnify"
                      single-line
                      hide-details
                      >
                      </v-text-field>
                      </v-card-text>
                      
                      <div>
                        <v-container>
                          <div v-for="(friend, i) in searchFriendList" :key="i">
                              <v-container>

                              <v-row>
                                <v-col cols='2'>
                                <v-avatar>
                                  <img
                                    src="https://cdn.vuetifyjs.com/images/john.jpg"
                                    alt="John"
                                  >
                                </v-avatar>
                                </v-col>
                                <v-col class="d-flex align-center pl-2" cols='5' 
                                style="font-size: 0.9rem; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
                                >{{ friend[1] }}</v-col>
                                <v-col class="d-flex align-center" cols='3' 
                                style="font-size: 0.9rem; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"
                                >{{ friend[2] }}</v-col>
                                <v-col class="d-flex align-center" cols='2'><v-icon @click="addTemporaryList(friend)">mdi-plus</v-icon></v-col>
                              </v-row>
                              </v-container>
                          </div>
                        </v-container>
                      </div>

                    <v-card-actions>
                      <v-spacer></v-spacer>
                      <v-btn
                        color="indigo darken-1"
                        text
                        @click="cancelAdd"
                      >
                        취소
                      </v-btn>
                      <v-btn
                        color="indigo darken-1"
                        text
                        @click="addMyFriendList"
                      >
                        확인
                      </v-btn>
                    </v-card-actions>
                  </v-card>
                </v-dialog>
            
            <MypageFriendList :dbfriend='this.dbfriend' @get_freind_list="getFreindList"/>
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
      };
import MypageLikePlace from "../../components/user/mypage/MypageLikePlace"
import MypageFriendList from "../../components/user/mypage/MypageFriendList"

export default {
    name: 'MyPage',
    components: {
      MypageLikePlace,
      MypageFriendList,
    },
    methods: {
      addTemporaryList(friend) {
        for (var fr of this.friendlist){
          if (friend[1] === fr[2]){
            alert("이미 추가된 친구입니다!")
            return
          }
        }
        this.tmplist.push([friend[0], friend[2], friend[1]])
      },
      addMyFriendList () {
        this.dbfriend = []
        var dbfriend2 = []
        // console.log(this.tmplist)
        for(let fr of this.tmplist) {
          axios.post(`http://localhost:8000/letsmeet/mypage/friend/add?friend=${fr[0]}&myUNo=${this.$store.state.uNo}`, config)
          .then(()=> {
            dbfriend2.push(fr)
          })
          .catch(()=> {
            console.log('못드감')
          })
        }
        this.dialog = false
        console.log(this.dbfriend)
        console.log(dbfriend2)
        this.dbfriend = dbfriend2
        this.tmplist = []
      },

      searchUserData() {
        this.searchFriendList = []
        if (this.addFriend.length > 0) {
          axios.get(`http://localhost:8000/letsmeet/mypage/friend/search?uEmail=${this.addFriend}`, config)
          .then((res)=> {
            // 비어 있지않을 때
            const array = res.data
            if (array.length) {
              array.forEach(li => {
                if(li.uNo === this.$store.state.uNo) return
                this.searchFriendList.push([li.uNo, li.uEmail, li.uName])
              });
            console.log(this.searchFriendList)
            this.addFriend = ''
            } else {
              alert('검색 결과가 없습니다.')
            }
          })
          .catch(()=> {
          })
        }
      },

      logout () {
        this.$store.dispatch('LOGOUT')
        .then(()=> {
          this.$router.replace({ name: 'Login'})
        })
      },
      cancelAdd() {
        this.tmplist = []
        this.dialog = false
      },
      deleteTemporaryList(idx) {
        this.tmplist.splice(idx, 1)
      },
      getFreindList(data) {
        this.friendlist = data
      }
    },
    mounted() { 
      this.uEmail = this.$store.state.uEmail
      this.uName= this.$store.state.uName
    },
    data: () => {
      return {
        tmplist: [],
        friendlist: [],
        UserNo: null,
        tab: null,
        dbfriend : [],
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