<template>
  <div
    class="flex h-screen items-center justify-center space-x-16 bg-black text-white"
  >
    <date-time id="japan" place="JAPAN" :date-time-value="state.japanTime" />
    <date-time id="here" place="HERE" :date-time-value="state.hereTime" />
  </div>
</template>

<script lang="ts">
  import { defineComponent, onMounted, reactive } from "vue"
  import DateTime from "./components/DateTime.vue"
  import moment from "moment-timezone"
  import { DateTimeFormat, TimeData } from "./types/common"
  import axios from "axios"

  export default defineComponent({
    name: "App",
    components: {
      "date-time": DateTime,
    },
    setup: () => {
      const CurrentTimeZone = moment.tz.guess(true)
      const JapanTimeZone = "Asia/Tokyo"
      const state = reactive({
        japanTime: "",
        hereTime: "",
      })

      onMounted(() => {
        computeTime()
      })

      const computeTime = async () => {
        state.japanTime = await fetchJapanTime()
        state.hereTime = moment
          .tz(state.japanTime, JapanTimeZone)
          .clone()
          .tz(CurrentTimeZone)
          .format(DateTimeFormat.ISO_LOCAL_DATE_TIME)

        setTimeout(() => computeTime(), 1000)
      }

      const fetchJapanTime = async (): Promise<string> => {
        const response = await axios.get<TimeData>(
          "http://localhost:80/japan-time-now"
        )
        return response.data.value
      }
      return {
        state,
      }
    },
  })
</script>

<style></style>
