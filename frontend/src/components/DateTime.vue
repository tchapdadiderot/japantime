<template>
  <div class="text-center flex flex-col items-center space-y-3 text-indigo-100">
    <p v-if="!isInvalidDate" id="date" class="tracking-widest text-xl">
      {{ state.date }}
    </p>
    <p id="time" class="tracking-wider text-5xl">
      {{ isInvalidDate ? "Fetching date..." : state.time }}
    </p>
    <p v-if="!isInvalidDate" id="place" class="tracking-widest text-base">
      {{ place }}
    </p>
  </div>
</template>

<script lang="ts">
import { reactive, defineComponent, onBeforeMount, watchEffect, computed } from "vue";
  import moment from "moment"
  import { DateTimeFormat } from "../types/common"

  export default defineComponent({
    name: "DateTime",
    props: {
      dateTimeValue: {
        type: String,
        required: true,
      },
      place: {
        type: String,
        required: true,
      },
    },
    setup: (props) => {
      const state = reactive({
        date: "2021-04-25 SUN",
        time: "",
      })
      watchEffect(() => {
        const dateTimeMoment = moment(props.dateTimeValue)
        state.date = dateTimeMoment.format(DateTimeFormat.DATE_DAY)
        state.time = dateTimeMoment.format(DateTimeFormat.TIME_DIGITAL)
      })
      const isInvalidDate = computed(() => state.date === "Invalid date")
      return { state, isInvalidDate }
    },
  })
</script>

<style scoped></style>
