describe("Main", () => {
  it("should display header text", () => {
    cy.intercept("**/japan-time-now", req => {
      req.reply({
        value: "2021-04-26T05:25:30"
      })
    })

    cy.visit("/")
    cy.contains("#japan #date", "2021-04-26 Mon")
    cy.contains("#japan #time", "05:25:30")
    cy.contains("#japan #place", "JAPAN")
    cy.contains("#here #date", "2021-04-25 Sun")
    cy.contains("#here #time", "21:25:30")
    cy.contains("#here #place", "HERE")
  })
})
