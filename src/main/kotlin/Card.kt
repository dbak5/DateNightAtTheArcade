class Card {

    //region Set default parameters and initialise 
    var creditBalance = 0.00
    var ticketBalance = 0.00

    init {
        creditBalance
        ticketBalance
    }
    //endregion 

    //region Methods 

    //Increment count of cards created 
    companion object {
        private var counter = 0
    }

    private val cardNumber = ++counter

    // Display card ticket and credit balances
    // Always print when credits or tickets are accessed through a terminal
    fun checkBalance(card: Card) {
        println("\nCard number: ${card.cardNumber}")
        println("Credit balance: ${card.creditBalance}")
        println("Ticket balance: ${card.ticketBalance}")
    }

    //endregion 
} 