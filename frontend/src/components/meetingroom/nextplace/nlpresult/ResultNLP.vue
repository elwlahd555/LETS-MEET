<template>
    <v-container>
      <!-- <vue-word-cloud
        style="
          height: 300px;
          width: 300px;
        "
        :words="new_words"
        :color="([, weight]) => weight > 1 ? 'DeepPink' : weight > 0 ? 'RoyalBlue' : 'Indigo'"
        font-family="Roboto"
        :wordClick="wordClickHandler"
      /> -->
      <v-row>

      <vue-word-cloud class="vue-word" :words="new_words"  style=" height: 300px; width: 300px;" 
      :color="([, weight]) => weight > 1 ? 'DeepPink' : weight > 0 ? 'RoyalBlue' : 'Indigo'"
      font-family="Roboto">
        <template slot-scope="{text, weight}">
          <div class='heretext' :title="weight" style="cursor: pointer;" animation-overlap>
            {{ text }}
          </div>
          <!-- <div class="showtext">
            {{ weight }}
          </div> -->
        </template> 
      </vue-word-cloud>
      </v-row>

          <v-simple-table dense>
            <template v-slot:default>
              <thead>
                <tr>
                  <th class="text-left">
                    단어
                  </th>
                  <th class="text-left">
                    빈도수
                  </th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(item, i) in new_words"
                  :key="i"
                >
                  <td>{{ item[0] }}</td>
                  <td>{{ item[1] }}</td>
                </tr>
              </tbody>
            </template>
          </v-simple-table>
    </v-container>
</template>
<script>
import VueWordCloud from 'vuewordcloud';
const axios = require('axios')
export default {
    name: 'ResultNLP',
    components: {
      [VueWordCloud.name]: VueWordCloud,
    },
    data: ()=> {
      return {
        chatContent: "",
        words: {},
        new_words: []
      }
    },
    mounted () {
      this.getData()
    },
    methods: {
      getData() {
        // 채팅방 내용들 다 받아오기
        axios.get(`http://localhost:8000/letsmeet/chat/open?mrcMrNo=3`)
        .then((res)=> {
          res.data.forEach((content)=> {
            this.chatContent += content.mrcContent
          })
          this.analyzeNLP(this.chatContent)
          console.log(this.words)
          for (var wo of Object.keys(this.words)){
            console.log(this.words[wo])
          }

        })
        .catch(()=> {
          console.log('안됨')
        })
      },
      analyzeNLP (data) {
        axios.post('http://aiopen.etri.re.kr:8000/WiseNLU', {
          'access_key': '1d00844e-0b14-498b-a3c8-017784783627',
          'argument': {
              'text': data,
              'analysis_code': 'ner'
          },
          headers: {'Content-Type':'application/json; charset=UTF-8'}
        })
        .then((res)=> {
          res.data.return_object.sentence.forEach((sentence) => {
            sentence.morp.forEach((morpheme) => {
              if(morpheme.type === 'NNG') {
                let word = morpheme.lemma
                    if (word in this.words) {
                      this.words[word] += 1
                    } else {
                      this.words[word] = 1
                    }
                  }
                })
              })
              for( const [key, value] of Object.entries(this.words)){
                this.new_words.push([key, value])
              }
              this.new_words.sort(function (a, b){
                return b[1] - a[1]
              })
              this.new_words = this.new_words.slice(0, 5)
            })
        .catch((err)=>{
          console.log(err)
        })
    } 
  }
}
</script>
<style scoped>
.vue-word {
  display: flex;
  left: 63px;
}

</style>