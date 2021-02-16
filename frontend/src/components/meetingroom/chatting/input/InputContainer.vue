<template>
  <div class="input__container">
    <slot name="input-field">
      <input-field
        v-model="message"
        @newOwnMessage="onNewOwnMessage"
        @input_message="inputMessage" />
    </slot>
    <slot name="input-button">
      <input-button @newOwMnessage="onNewOwnMessage" />
    </slot>
  </div>
</template>

<script>
import InputField from './InputField.vue'
import InputButton from './InputButton.vue'

export default {
  name: 'InputContainer',
  components: {
    InputField,
    InputButton,
  },
  data: function () {
    return {
      message: '',
    }
  },
  methods: {
    onNewOwnMessage () {
      if (!this.message || this.message === '') {
        return
      }
      this.$emit('newOwnMessage', this.message)
      this.message = ''
    },
    inputMessage(value) {
      this.message = value
    }
  }
}
</script>

<style lang="scss" scoped>
.visible {
  display: none;
}
</style>
