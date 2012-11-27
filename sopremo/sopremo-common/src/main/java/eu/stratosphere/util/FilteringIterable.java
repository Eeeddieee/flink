/***********************************************************************************************************************
 *
 * Copyright (C) 2010-2012 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 **********************************************************************************************************************/
package eu.stratosphere.util;

import java.util.Iterator;

/**
 * Filters the elements of an {@link Iterable} with a given {@link Predicate}.<br>
 * Changes to the parameters are directly reflected in the result.
 * 
 * @author Arvid Heise
 */
public class FilteringIterable<T> extends WrappingIterable<T, T> {

	private final Predicate<T> selector;

	public FilteringIterable(final Iterable<? extends T> originalIterable, final Predicate<T> selector) {
		super(originalIterable);
		this.selector = selector;
	}

	/*
	 * (non-Javadoc)
	 * @see eu.stratosphere.util.AbstractIterable#wrap(java.util.Iterator)
	 */
	@Override
	protected Iterator<T> wrap(final Iterator<? extends T> iterator) {
		return new FilteringIterator<T>(iterator, this.selector);
	}
}
