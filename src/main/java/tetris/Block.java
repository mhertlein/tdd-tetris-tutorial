// Copyright (c) 2008-2012  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author mhertlein
 */
public class Block {
    final private char icon;

    public Block(char icon) {
        this.icon = icon;
    }

    public char getIcon() {
        return icon;
    }
}
