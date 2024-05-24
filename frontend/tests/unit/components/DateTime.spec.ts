import { mount } from "@vue/test-utils"
import DateTime from "../../../src/components/DateTime.vue"

describe("DateTime", () => {
  it("should display data correctly", () => {
    const dateTimeValue = "2021-04-26T05:25:30"
    const place = "Tokyo"
    const wrapper = mount(DateTime, {
      props: {
        dateTimeValue,
        place,
      },
    })
    expect(wrapper.find("#date").text()).toEqual("2021-04-26 Mon")
    expect(wrapper.find("#time").text()).toEqual("05:25:30")
    expect(wrapper.find("#place").text()).toEqual(place)
  }),

  it("invalid date test", () => {
    const dateTimeValue = ""
    const place = "Tokyo"
    const wrapper = mount(DateTime, {
      props: {
        dateTimeValue,
        place,
      },
    })
    expect(wrapper.find("#date").exists()).toBeFalsy();
    expect(wrapper.find("#time").text()).toEqual("Fetching date...")
    expect(wrapper.find("#place").exists()).toBeFalsy();
  })
})
