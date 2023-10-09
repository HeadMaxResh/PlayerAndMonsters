package entity

import kotlin.random.Random

abstract class Creature(
    private var attack: Int,
    private var protection: Int,
    protected var health: Int,
    private var minDamage: Int,
    private var maxDamage: Int) {

    val isAlive: Boolean
        get() = health > 0

    val maxHealth: Int = health

    fun attack(creature: Creature): Int {
        if (isAlive){
            if (creature != this) {
                if (creature.isAlive) {
                    println("$this attack $creature")
                    val modifier = attackModifier(creature)
                    val success = getSuccess(modifier)
                    val damage = getDamage(success, minDamage, maxDamage)
                    val newHealth = creature.health - damage
                    creature.setHealth(newHealth)
                    printHealth(creature)
                } else {
                    println("The $creature is already dead")
                }
            } else {
                println("Cant self attack")
            }
        } else {
            println("$this is dead, he cant attack")
        }
        return attack
    }

    private fun getDamage(success: Boolean, minDamage: Int, maxDamage: Int): Int {
        var damage = 0
        if (success) {
            println("Attack success")
            damage = Random.nextInt(minDamage, maxDamage + 1)
        } else {
            println("Attack not success")
        }
        return damage
    }

    private fun getSuccess(modifier: Int): Boolean {
        var success = false
        if (modifier <= 0) return success
        for (i in 0 until modifier) {
            val diceValue = Random.nextInt(1, 7)
            if (diceValue >= 5) {
                success = true
            }
        }
        return success
    }

    private fun printHealth(creature: Creature) {
        if (creature.isAlive) {
            println("$creature health ${creature.health}")
        } else {
            println("$creature is dead")
        }
    }

    private fun attackModifier(creature: Creature): Int {
        return attack - creature.protection + 1
    }

    protected fun setHealth(newHealth: Int): Int {
        this.health = when {
            newHealth < 0 -> 0
            newHealth > maxHealth -> maxHealth
            else -> newHealth
        }
        return health
    }
}