package planets;
/*
 * Copyright (c) 2002-2008 LWJGL Project All rights reserved. Redistribution and
 * use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met: * Redistributions of source
 * code must retain the above copyright notice, this list of conditions and the
 * following disclaimer. * Redistributions in binary form must reproduce the
 * above copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the distribution. *
 * Neither the name of 'LWJGL' nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Sets up the window and all the GL stuff. Subclass this to but the game update
 * and draw logic.
 *
 * @author Evan Tatarka
 */
public abstract class Game
{
    private long            timerTicksPerSecond;

    private boolean         gameRunning;

    /**
     * The number of frames per second. This defaults to 60.
     */
    public static final int FPS = 60;

    private int             width;
    private int             height;

    /**
     * Construct our game and set it running.
     *
     * @param width
     *            the width of the game
     * @param height
     *            the height of the game
     * @param drawPanel
     *            the drawPanel to draw the game on in windowed mode.
     */
    public Game(int width, int height, DrawPanel drawPanel)
    {
        this.width = width;
        this.height = height;

        gameRunning = false;
        timerTicksPerSecond = Sys.getTimerResolution();

        // Tell LWJGL to draw in our drawPanel's canvas
        try
        {
            Display.setParent(drawPanel.getCanvas());
        }
        // If something prevents the display from being created
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }

        initialize();
    }


    /**
     * Get the high resolution time in milliseconds
     *
     * @return The high resolution time in milliseconds
     */
    private long getTime()
    {
        // we get the "timer ticks" from the high resolution timer
        // multiply by 1000 so our end result is in milliseconds
        // then divide by the number of ticks in a second giving
        // us a nice clear time in milliseconds
        return (Sys.getTime() * 1000) / timerTicksPerSecond;
    }


    /**
     * Initialize the common elements for the game
     */
    private void initialize()
    {
        // initialize the window beforehand
        try
        {
            Display.create();
            Display.setDisplayMode(new DisplayMode(width, height));
        }
        catch (LWJGLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Keyboard.enableRepeatEvents(false);

        // enable textures since we're going to use these for our sprites
        glEnable(GL_TEXTURE_2D);

        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glViewport(0, 0, width, height);
    }


    /**
     * Sleep for a fixed number of milliseconds.
     *
     * @param duration
     *            The amount of time in milliseconds to sleep for
     */
    private void sleep(long duration)
    {
        try
        {
            Thread.sleep((duration * timerTicksPerSecond) / 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Run the main game loop. This method keeps rendering the scene and
     * requesting that the callback update its screen.
     */
    private void gameLoop()
    {
        while (gameRunning)
        {
            // clear screen
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glMatrixMode(GL_MODELVIEW);
            glLoadIdentity();

            long preRoutineTime = getTime();

            // run game logic
            update(preRoutineTime);

            // let subsystem paint
            draw();

            // update window contents
            Display.update();

            // stabilize the FPS
            keepTime(preRoutineTime);
        }

        // clean up
        Display.destroy();
    }

    /**
     * Stabilize the FPS
     * @param currentTime The time before calling game routines
     */
    private void keepTime(long preRoutineTime)
    {
        long elapsedTime = getTime() - preRoutineTime;
        long targetTime = (long)(1000 * (1 / (double)FPS));

        // Sleeps to keep in time with the FPS
        if (elapsedTime < targetTime)
        {
            sleep(targetTime - elapsedTime);
        }
    }


    // ----------------------------------------------------------
    /**
     * Loads all the assests for the game and initializes everything.
     */
    public abstract void load();


    // ----------------------------------------------------------
    /**
     * Updates the game loop. This at a rate based on the FPS.
     *
     * @param gameTime
     */
    public abstract void update(long gameTime);


    // ----------------------------------------------------------
    /**
     * Draws the game.
     */
    public abstract void draw();


    /**
     * Starts the game for the first time
     */
    public void execute()
    {
        load();
        gameRunning = true;
        gameLoop();
    }


    // ----------------------------------------------------------
    /**
     * Starts or stops the game
     * @param isRunning Whether you want the game to run or stop
     */
    public void setRunning(boolean isRunning)
    {
        gameRunning = isRunning;
    }

    // ----------------------------------------------------------
    /**
     * Determines if the game is running.
     *
     * @return true if it is, false otherwises
     */
    public boolean isRunning()
    {
        return gameRunning;
    }
}
