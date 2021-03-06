/*
 *     This file is part of Discord4J.
 *
 *     Discord4J is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Discord4J is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package sx.blah.discord.handle.impl.events.guild.channel.message;

import sx.blah.discord.handle.obj.IEmbed;
import sx.blah.discord.handle.obj.IMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * This event is dispatched whenever a message is edited.
 */
public class MessageEmbedEvent extends MessageEvent {

	private final List<IEmbed> newEmbed;

	public MessageEmbedEvent(IMessage message, List<IEmbed> oldEmbed) {
		super(message);
		List<IEmbed> tempArray = new ArrayList<>();
		for (IEmbed attachment : message.getEmbedded()) {
			if (!oldEmbed.contains(attachment)) {
				tempArray.add(attachment);
			}
		}
		newEmbed = tempArray;
	}

	/**
	 * The new embedded media that has been added to the message.
	 *
	 * @return An array of the new embedded media.
	 */
	public List<IEmbed> getNewEmbed() {
		return newEmbed;
	}
}
