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
              <h2>bye</h2>
            </v-card>
          </v-tab-item>
        </v-tabs-items>
    </div>
</template>
<script>

export default {
    name: 'MyPage',
    components: {
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