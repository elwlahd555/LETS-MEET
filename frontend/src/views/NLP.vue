<template>
    <div>
        <vue-word-cloud
            style="
              height: 480px;
              width: 640px;
            "
            :new_words="new_words"
            :color="([, weight]) => weight > 10 ? 'DeepPink' : weight > 5 ? 'RoyalBlue' : 'Indigo'"
            font-family="Roboto"
          />
    </div>
</template>
<script>
const axios = require('axios')
export default {
    name: 'NLP',
    data: ()=> {
      return {
        chatContent: "",
        words: {},
        new_words: []
      }
    },
    created () {
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
        // var access_key = '1d00844e-0b14-498b-a3c8-017784783627';
        // var analysisCode = 'ner';

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
            })
        .catch((err)=>{
          console.log(err)
        })
      //   let words = {'a': 1}
      //   var openApiURL = "http://aiopen.etri.re.kr:8000/WiseNLU_spoken";
      //   // var text = '';

      //     var requestJson = {
      //       'access_key': access_key,
      //       'argument': {
      //           'text': data,
      //           'analysis_code': analysisCode
      //       }
      //   };
        
      //   var request = require('request');
      //   var options = {
      //       url: openApiURL,
      //       body: JSON.stringify(requestJson),
      //       headers: {'Content-Type':'application/json; charset=UTF-8'}
      //   };
      //   words['B'] = 2
      //   request.post(options, function (error, response, body) {
      //       console.log('responseCode = ' + response.statusCode);
      //       console.log('----------------------------------------')
      //       // console.log('responseBody = ' + body);
      //       let obj = JSON.parse(body);
      //       // console.log(obj["return_object"]["sentence"][0]["morp"])
      //       let check = obj.return_object.sentence[0].morp
      //       this.words = check
      //       check.forEach(el => {
      //           if (el.type === "NNG") {
      //             let word = el.lemma
      //               if (word in words) {
      //                 words[word] += 1
      //               } else {
      //                 words[word] = 1
      //               }
      //           }
      //       });

      //   });
      // console.log(words)
      // this.words = words
    } 
  }
}
</script>