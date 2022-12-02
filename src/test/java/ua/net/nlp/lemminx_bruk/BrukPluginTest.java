/**
 * Copyright (C) cedarsoft GmbH.
 *
 * Licensed under the GNU General Public License version 3 (the "License")
 * with Classpath Exception; you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *         http://www.cedarsoft.org/gpl3ce
 *         (GPL 3 with Classpath Exception)
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 3 only, as
 * published by the Free Software Foundation. cedarsoft GmbH designates this
 * particular file as subject to the "Classpath" exception as provided
 * by cedarsoft GmbH in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 3 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 3 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact cedarsoft GmbH, 72810 Gomaringen, Germany,
 * or visit www.cedarsoft.com if you need additional information or
 * have any questions.
 */

package ua.net.nlp.lemminx_bruk;

import static org.eclipse.lemminx.XMLAssert.c;
import static org.eclipse.lemminx.XMLAssert.te;
import static org.eclipse.lemminx.XMLAssert.testCompletionFor;

import org.eclipse.lemminx.AbstractCacheBasedTest;
import org.eclipse.lemminx.commons.BadLocationException;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class BrukPluginTest extends AbstractCacheBasedTest {

	@Test
	public void testCompletionLemma() throws BadLocationException {

		String xml = "<?xml version=\"1.0\"?>\r\n" +
				"<token value=\"голова\" lemma=\"" +
				"|";

//		testCompletionFor(xml,
//				c("голова", te(1, 29, 1, 28, "голова"), "голова") 
//				);
	}

	@Test
	public void testCompletionTags() throws BadLocationException {

		String xml = "<?xml version=\"1.0\"?>\r\n" +
				"<token value=\"голова\" lemma=\"голова\" tags=\"" +
				"|";

//		testCompletionFor(xml,
//				c("noun:anim:f:v_naz", te(1, 43, 1, 42, "noun:anim:f:v_naz"), "noun:anim:f:v_naz"), 
//				c("noun:anim:m:v_naz", te(1, 43, 1, 42, "noun:anim:m:v_naz"), "noun:anim:m:v_naz"),
//				c("noun:inanim:f:v_naz", te(1, 43, 1, 42, "noun:inanim:f:v_naz"), "noun:inanim:f:v_naz")
//		);
  }
}
