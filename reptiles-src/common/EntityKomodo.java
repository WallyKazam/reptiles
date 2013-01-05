//
// This work is licensed under the Creative Commons
// Attribution-ShareAlike 3.0 Unported License. To view a copy of this
// license, visit http://creativecommons.org/licenses/by-sa/3.0/
//

package reptiles.common;

import java.util.*;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;


public class EntityKomodo extends EntityVaranus {
	
	private EntityAINearestAttackableTarget attackPlayer = new EntityAINearestAttackableTarget(this, EntityPlayer.class, attackDistance, targetChance * 2, true);
	private boolean playerAttack = true;

	public EntityKomodo(World world) {

		super(world);
		texture = "/mob/komodo32.png";
		tasks.addTask(4, new EntityAIAttackOnCollide(this, EntitySheep.class, this.moveSpeed, true));
		targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntitySheep.class, attackDistance, targetChance, false));
		targetTasks.addTask(5, attackPlayer);
	}

	public EntityAnimal spawnBabyAnimal(EntityAgeable entityageable) {
		EntityKomodo e = new EntityKomodo(worldObj);
		if (isTamed()) {
			e.setOwner(getOwnerName());
			e.setTamed(true);
		}
		System.out.printf("Spawned entity of type %s", getClass().toString());
		return e;
	}
	
	// the idea is that if the entity is tame to remove the 
	// targetTask entry for the List so the player
	// is not attacked by a tame komodo
	protected void updateAITasks() {
		if (playerAttack && isTamed()) { // don't attack players when tame
			targetTasks.taskEntries.remove(attackPlayer);
			playerAttack = false;
		}
		super.updateAITasks();
	}

}
