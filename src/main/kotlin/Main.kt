import entity.Monster
import entity.Player

fun main() {
    val player = Player(15, 12, 100, 50, 60)
    val monster = Monster(12, 4, 100, 20, 30)

    monster.attack(player)
    monster.attack(player)
    monster.attack(player)
    monster.attack(player)
    monster.attack(player)

    player.heal()
}