package entity

class Player(
    attack: Int,
    protection: Int,
    health: Int,
    minDamage: Int,
    maxDamage: Int,
) : Creature(attack, protection, health, minDamage, maxDamage) {

    private var countHeals = 0

    fun heal(): Int {
        if (isAlive) {
            val sizeHeal = (maxHealth * 0.3).toInt()
            if (countHeals < 4) {
                val newHealth = health + sizeHeal
                setHealth(newHealth)
                println("Use of heal, current $this's health $health")
                countHeals++
            } else {
                println("$this heals is over")
            }
            return sizeHeal
        }
        println("$this is dead, he cant heal")
        return 0
    }

    override fun toString(): String {
        return "Player"
    }
}