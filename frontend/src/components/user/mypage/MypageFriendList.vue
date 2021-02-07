<template>
  <div >
    <div class='p-2' v-for="(friend, i) in allmyfriendlist" :key="i">
      <div>
        <v-container>
          <v-row>
          <v-avatar>
            <img
              src="https://cdn.vuetifyjs.com/images/john.jpg"
              alt="John"
            >
          </v-avatar>
            <v-col>{{ friend[1] }}</v-col>
            <v-col>{{ friend[2] }}</v-col>
            <v-col class="text-right" @click='deleteFriend(i, friend[0])'><v-icon>mdi-trash-can</v-icon></v-col>
          </v-row>
        </v-container>
         <!-- <div class="d-inline-flex pl-3">
           {{ friend.uName }}
           </div>
           <div class='d-inline-flex pl-3'>
             {{ friend.uEmail }}
            </div>
          <div class="d-inline-flex" @click="deleteFriend"></div> -->
      </div>
    </div>
    </div>
</template>
<script>
const axios = require('axios');
// const config = {
//           headers: { 'auth-token': window.localStorage.getItem('auth-token') },
//       }
export default {
  name: 'MypageFriendList',
  props: {
    dbfriend: Array,
  },
  created() {
    this.friendList()
  },
  watch: {
    dbfriend(db) {
      this.allmyfriendlist.push(db)
    },
    // allmyfriendlist() {
    //   this.$emit('refresh')
    // } 
  },
  computed: {
    checkitall: function () {
      return this.allmyfriendlist
    }
  },
  methods: {
    friendList(){
     axios.get(`http://localhost:8000/letsmeet/mypage/friend?myUNo=${this.$store.state.uNo}`)
      .then((res)=> {
        const array = res.data
        array.forEach(el => {
          this.allmyfriendlist.push([el.uNo, el.uName, el.uEmail])
        });
        console.log(this.allmyfriendlist)
      })
      .catch(()=> {
        console.log('data 못받아옴')
      })
    },
    deleteFriend(index, friend) {
      this.allmyfriendlist.splice(index, 1)
      axios.delete(`http://localhost:8000/letsmeet/mypage/friend/delete?friend=${friend}&myUNo=${this.$store.state.uNo}`)
      .then(()=> {
        console.log('성공')
      })
      .catch(()=> {
        console.log('실패')
      })
    },
  },
  data: () => {
    return {
      allmyfriendlist: [],
    }
  }
}
</script>