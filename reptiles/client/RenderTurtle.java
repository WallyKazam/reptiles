//  
//  =====GPL=============================================================
//  This program is free software; you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation; version 2 dated June, 1991.
// 
//  This program is distributed in the hope that it will be useful, 
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
// 
//  You should have received a copy of the GNU General Public License
//  along with this program;  if not, write to the Free Software
//  Foundation, Inc., 675 Mass Ave., Cambridge, MA 02139, USA.
//  =====================================================================
//
package com.reptiles.client;

import com.reptiles.common.EntityTurtle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;

public class RenderTurtle extends RenderLiving {

	private static final ResourceLocation skin = new ResourceLocation("reptilemod", "textures/entity/reptiles/tortoise.png");

	public RenderTurtle(RenderManager rm, ModelBase modelbase, float shadowSize)
	{
		super(rm, modelbase, shadowSize);
	}

	public void renderTurtle(EntityTurtle entityturtle, double d, double d1, double d2, float f, float f1)
	{
		super.doRender(entityturtle, d, d1, d2, f, f1);
	}

	@Override
	public void doRender(EntityLiving entity, double d, double d1, double d2, float f, float f1)
	{
		renderTurtle((EntityTurtle) entity, d, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return skin;
	}

}
