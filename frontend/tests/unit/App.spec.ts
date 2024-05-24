import { mount } from "@vue/test-utils"
import App from "../../src/App.vue"
import Any = jasmine.Any

const dateTimeValue = "2021-04-26T05:25:30"

jest.mock("axios", () => {
  return {
    get: (url: string) => {
      return {
        data: {
          value: dateTimeValue,
        },
      }
    },
  }
})

const delay = (ms: number): Promise<Any> =>
  new Promise((res) => setTimeout(res, ms))

describe("App", () => {
  it("should display data correctly", async () => {
    const wrapper = mount(App)
    await delay(1000)
    const allDates = wrapper.findAll("#date").map((c) => c.text())
    expect(allDates.length).toEqual(2)
    expect(allDates.includes("2021-04-26 Mon")).toBeTruthy()

    const allTimes = wrapper.findAll("#time").map((c) => c.text())
    expect(allTimes.length).toEqual(2)
    expect(allTimes.includes("05:25:30")).toBeTruthy()

    const allPlaces = wrapper.findAll("#place").map((c) => c.text())
    expect(allPlaces.length).toEqual(2)
    expect(allPlaces.includes("JAPAN")).toBeTruthy()
    expect(allPlaces.includes("HERE")).toBeTruthy()
  })
})
