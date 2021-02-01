<template>
  <v-container>
    <v-expansion-panels class="mb-5">
      <v-expansion-panel>
        <v-expansion-panel-header>
          <template v-slot:default="{ open }">
            <v-row no-gutters>
              <v-col cols="12">
                <h5>이모저모 런닝 모임</h5>
              </v-col>
              <v-col
                cols="12"
                class="text--secondary"
              >
                <v-fade-transition leave-absolute>
                  <span
                    v-if="open"
                    key="0"
                  >
                    방 상세 정보
                    <hr>
                  </span>
                  <span
                    v-else
                    key="1"
                  >
                  </span>
                </v-fade-transition>
              </v-col>
            </v-row>
          </template>
        </v-expansion-panel-header>
        <v-expansion-panel-content>
          멤버 : 홍길동 외 4명 <br>
          시간 : 미정 <br>
          장소 : 미정 <br>
        </v-expansion-panel-content>
      </v-expansion-panel>
    </v-expansion-panels>



    <v-sheet elevation="6">
    <v-tabs
      background-color="indigo accent-2"
      dark
      centered
      next-icon="mdi-arrow-right-bold-box-outline"
      prev-icon="mdi-arrow-left-bold-box-outline"
      show-arrows
      v-model="tab"
    >
      <v-tab>
        약속 선택
      </v-tab>
      <v-tab>
        장소 추천
      </v-tab>
      <v-tab>
        채팅
      </v-tab>
      <v-tab>
        멤버
      </v-tab>
    </v-tabs>

    <v-tabs-items v-model="tab">
      <v-tab-item>
        <DeterminePromise />
      </v-tab-item>
      <v-tab-item>
        22
      </v-tab-item>
      <v-tab-item>
        <Chatting />
      </v-tab-item>
      <v-tab-item>
        <Member />
      </v-tab-item>
    </v-tabs-items>
  </v-sheet>
  </v-container>
</template>

<script>
import Member from "../../components/meetingroom/member/Member.vue";
import DeterminePromise from "../../components/meetingroom/determinepromise/DeterminePromise.vue";
import Chatting from "../../components/meetingroom/chatting/Chatting.vue";


export default {
  name: "MeetingRoom",
  components: {
    Member,
    DeterminePromise,
    Chatting,
  },
  data () {
    return {
      tab: 'tab-1',
    }
  },
}
</script>
<style scoped>
</style>