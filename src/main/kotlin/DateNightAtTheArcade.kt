/*
Name: DaHye Baker
ID: 30063368
Assessment 1: Activity 3
*/

fun main() {

    //region Create 2 cards
    val card1 = Card() // A card created with a unique id (1)
    val card2 = Card() // Another card created with a unique id (2)

    println("\n>>> Cards created")
    card1.checkBalance(card1)
    card2.checkBalance(card2)

    //endregion

    //region Create 2 games
    val game1 = Game(5) // A playable game which costs 5 credits per play
    val game2 = Game(7) // Another playable game which costs 7 credits per play

    println("\n>>> Games created\n")
    println("Game ${game1.gameNumber} requires ${game1.creditsRequired} credits")
    println("Game ${game2.gameNumber} requires ${game2.creditsRequired} credits")

    //endregion

    //region Create 2 terminals
    val terminal1 = Terminal() // A terminal created
    val terminal2 = Terminal() // Another terminal created

    println("\n>>> Terminals created\n")
    println("Terminal ${terminal1.terminalNumber}")
    println("Terminal ${terminal2.terminalNumber}")

    //endregion

    //region Add credits to cards
    println("\n>>> 40 Credits added to each card")
    terminal1.addCredits(card1, 20) // add 40 credits with $20 into card1
    terminal1.addCredits(card2, 20) // add 40 credits with $20 into card2
    //endregion

    //region Play games to win tickets
    for (i in 0..4) {
        game1.playGame(card1) // play game1 5 times with card1
    }

    for (i in 0..4) {
        game2.playGame(card2) // play game1 5 times with card2
    }

    println("\n>>> Card #1 is used to play Game #1 5 times")
    card1.checkBalance(card1)
    println("\n>>> Card #2 is used to play Game #2 5 times")
    card2.checkBalance(card2)

    //endregion

    //region Transfer credit and ticket balances from card 1 to card 2
    println("\n>>> Credits transferred from Card #1 to Card #2")
    terminal1.transferCredits(card1, card2) // transfer credits from card1 to card2

    println("\n>>> Tickets transferred from Card #1 to Card #2")
    terminal1.transferTickets(card1, card2) // transfer tickets from card1 to card2
    //endregion

    //region Various tests using cards - request prizes and play games
    println("\n>>> Request prize Candy with Card #2")
    terminal1.requestPrize("Candy", card2) // request Candy with card2. may or may not be claimed.

    println("\n>>> Card #1 is used to play Game #1 one more time")
    game1.playGame(card1) // try to play game1 again with card1

    println("\n>>> Request different prizes with Card #1 and Card #2")
    // Request prize (Candy, Hat or Classes) with card1 or card 2
    // Prize may be claimed with enough tickets or may not if not enough tickets
    terminal1.requestPrize("Candy", card1)
    terminal1.requestPrize("Hat", card2)
    terminal1.requestPrize("Candy", card2)
    terminal1.requestPrize("Glasses", card2)
    terminal1.requestPrize("Candy", card2)
    terminal1.requestPrize("Candy", card2)
    //endregion
}