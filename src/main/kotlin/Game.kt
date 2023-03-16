import kotlin.random.Random

class Game(var creditsRequired: Int) {

    //region Methods

    // Increment count of games created
    companion object {
        private var counter = 0
    }

    val gameNumber = ++counter

    // Update creditBalance and ticketBalance on a card after one play
    fun playGame(card: Card) {
        // Check there is enough credit on the card
        if (card.creditBalance <= 0) {
            println("\nInsufficient credit balance")
        }
        // Generate random tickets and update ticketBalance
        else {
            card.creditBalance = card.creditBalance - creditsRequired
            var random = Random.nextInt(0, 50)
            card.ticketBalance = card.ticketBalance + random
        }
    }
    //endregion
}