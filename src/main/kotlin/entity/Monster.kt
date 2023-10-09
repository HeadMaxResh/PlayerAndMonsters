package entity

class Monster(
    attack: Int,
    protection: Int,
    health: Int,
    minDamage: Int,
    maxDamage: Int
) : Creature(attack, protection, health, minDamage, maxDamage) {

    override fun toString(): String {
        return "Monster"
    }
}