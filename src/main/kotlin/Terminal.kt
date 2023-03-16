import kotlin.random.Random

class Terminal() {

    //region Create prizes
    private var random = Random.nextInt(0, 50)
    private var prizeArray = arrayOf(
        Prize("Candy", random, 10),
        Prize("Hat", random, 5),
        Prize("Glasses", random, 6)
    )
    //endregion

    //region Methods

    //Increment count of cards created
    companion object {
        private var counter = 0
    }

    val terminalNumber = ++counter

    // Add credits to card
    fun addCredits(card: Card, inputAmt: Int) {
        card.creditBalance = card.creditBalance + inputAmt * 2
        card.checkBalance(card)
    }

    // Transfer balance of credits between cards
    fun transferCredits(fromCard: Card, toCard: Card) {
        toCard.creditBalance = fromCard.creditBalance + toCard.creditBalance
        fromCard.creditBalance = 0.0
        fromCard.checkBalance(fromCard)
        toCard.checkBalance(toCard)
    }

    // Transfer balance of tickets between cards
    fun transferTickets(fromCard: Card, toCard: Card) {
        toCard.ticketBalance = fromCard.ticketBalance + toCard.ticketBalance
        fromCard.ticketBalance = 0.0
        fromCard.checkBalance(fromCard)
        toCard.checkBalance(toCard)
    }

    // Exchange tickets for prizes
    // Display when prize is awarded and the remaining number of prizes
    fun requestPrize(prize: String, card: Card) {
        // Loop through the prize array
        for (i in prizeArray) {
            if (prize == i.prizeName) {
                // Check if there are enough tickets on the card
                if (card.ticketBalance < i.ticketsRequired) {
                    println("\nInsufficient ticket balance")
                }
                // Check if there are enough prizes in the terminal
                else if (i.prizeInventory <= 0) {
                    println("\nInsufficient ${i.prizeName} in terminal")
                }
                // Award prize
                else {
                    println("\n${i.prizeName} awarded")
                    card.ticketBalance = card.ticketBalance - i.ticketsRequired
                    card.checkBalance(card)
                    i.prizeInventory = i.prizeInventory - 1
                    println("\nThere are ${i.prizeInventory} ${i.prizeName} prizes remaining")
                }
            }
        }
    }
    //endregion
}