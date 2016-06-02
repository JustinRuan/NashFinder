package de.tischner.nashfinder.game.util;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 
 * @author Daniel Tischner
 *
 * @param <PLAYER>
 * @param <ACTION>
 */
public final class SupportSet<PLAYER, ACTION> {

	private final Set<ACTION> mActions;

	private final PLAYER mPlayer;

	public SupportSet(final PLAYER player) {
		this(player, null);
	}

	public SupportSet(final PLAYER player, final Set<ACTION> actions) {
		mPlayer = player;
		mActions = new LinkedHashSet<ACTION>();
		if (actions != null) {
			for (ACTION action : actions) {
				addAction(action);
			}
		}
	}

	public boolean addAction(final ACTION action) {
		return mActions.add(action);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SupportSet)) {
			return false;
		}
		SupportSet<?, ?> other = (SupportSet<?, ?>) obj;
		if (mActions == null) {
			if (other.mActions != null) {
				return false;
			}
		} else if (!mActions.equals(other.mActions)) {
			return false;
		}
		if (mPlayer == null) {
			if (other.mPlayer != null) {
				return false;
			}
		} else if (!mPlayer.equals(other.mPlayer)) {
			return false;
		}
		return true;
	}

	public Iterator<ACTION> getActions() {
		return mActions.iterator();
	}

	public PLAYER getPlayer() {
		return mPlayer;
	}

	public boolean hasAction(final ACTION action) {
		return mActions.contains(action);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mActions == null) ? 0 : mActions.hashCode());
		result = prime * result + ((mPlayer == null) ? 0 : mPlayer.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return mPlayer + ": " + mActions;
	}
}
