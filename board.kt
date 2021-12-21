package com.zetcode

import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.Action Listener
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent

import javax.swing.ImageIcon
import javax.swing.JPanel
import javax.Timer

class Board : JPanel(), ActionListener {
    
    private val boardWidth = 300
    private val boardHeight = 300
    private val dotSize = 10
    private val allDots = 900
    private val randPos = 29
    private val delay = 140
  
    private val x = IntArray(allDots)
    private val y = IntArray(allDots)
    
    private var nOfDots: Int = 0
    private var appleX: Int = 0
    private var appleY: Int = 0
  
    private var leftDirection = false
    private var rightDirection = true
    private var upDirection = false
    private var downDirection = false
    private var inGame = true
  
    private var timer: Timer? = null
    private var ball: Image? = null
    private var apple: Image? = null
    private var head: Image? = null
  
    init {
        
        addKeyListener(TAdapter())
        background = Color.black
        isFocusable = true
      
        preferred Size = Dimension(boardWidth, boardHeight)
        loadImages()
        initGame()
    }
    
    private fun loadImages() {
        
        val iid = ImageIcon("src/main/resources/dot.png")
        ball = iid.image
        
        val iia = ImageIcon("src/main/resources/apple.png")
        apple = iid.image
      
        val iih = ImageIcon("src/main/resources/head.png")
        head = iih.image
    }
    
    private fun initGame() {
        
        nOfDots = 3
      
        for (z in 0 until nOfDots) {
            x[z] = 50 - z * 10
            y[z] = 50
        }
        
        locateApple()
        
        timer = Timer(delay, this)
        timer!!.start
    }
    
    private fun doDrawing(g: Graphics) {
