<template>
  <v-container>
    <AddMember :members="members" @addMember="addMember"/>
    <v-list>
      <v-subheader>멤버 목록</v-subheader>
      <v-list-item-group v-model="model">
        <v-list-item
          v-for="(item, idx) in members"
          :key="idx"
        >
          <v-list-item-avatar>
            <v-img :src="item.avatar"></v-img>
          </v-list-item-avatar>

          <v-list-item-content>
            <v-list-item-title v-text="item.uName"></v-list-item-title>
          </v-list-item-content>

          <v-list-item-content>
            <v-list-item-title v-text="item.uEmail"></v-list-item-title>
          </v-list-item-content>

          <v-list-item-content v-if="!item.icon" class="m-0 p-0">
            <v-col @click='deleteMember(item.uNo)'><v-icon>mdi-trash-can</v-icon></v-col>
          </v-list-item-content>

          <v-list-item-content v-else class="m-0 p-0">
            <v-icon
              v-if="item.icon"
              color="pink"
            >
              mdi-star
            </v-icon>
          </v-list-item-content>
          
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-container>
</template>

<script>
const axios = require('axios');
import AddMember from './AddMember.vue'

export default {
  name: "Member",
  components: {
    AddMember,
  },
  data () {
    return {
      rNo: this.$route.params.id,
      members: [
      ],
      model: null,
    }
  },
  props: {
    mrUserInfo: Array,
    roomInfo: Object,
  },
  mounted() {
    // this.MemberList()
    this.getMemberList()
  },
  methods: {
    getMemberList(){
      for (var member of this.mrUserInfo) {
        var icon = false
        if (member.uNo === this.roomInfo.mrSuperUNo){
          icon = true
        }
        var data = {
          icon: icon,
          uName: member.uName,
          uEmail: member.uEmail,
          avatar: 'https://cdn.vuetifyjs.com/images/lists/1.jpg',
          uNo: member.uNo
        }
        this.members.push(data)
      }
    },
    deleteMember(uNo) {
      for (var i=0 ; i< this.members.length ; i++) {
        if (this.members[i].uNo === uNo){
          this.members.splice(i, 1)
        }
      }
      const data = {
        mruMrNo: parseInt(this.rNo),
        mruUNo: parseInt(uNo),
      }
      console.log(data)
      axios.delete(`http://localhost:8000/letsmeet/meetingRoomUser/delete`, {'mruUNo': 3})
      .then(()=> {
        console.log('성공')
      })
      .catch((err)=> {
        console.log(err)
      })
    },
    addMember(data) {
      this.members.push(data)
    },
  },
}
</script>

<style>

</style>