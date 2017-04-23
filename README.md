# AppiumGridServer
A tool is to setup Appium gird server using GUI, easy to use.

![appium-grid-server](https://cloud.githubusercontent.com/assets/4379558/25313072/500595b2-2851-11e7-8df4-0a2a12b16c9c.png)

### Why you need this tool?
* You don't need to know how to start a grid server with complex parameters
* You don't need to create many node JSON files for each appium server

### Setup Appium Parallel Execution
#### Setup a Grid server
Open [AppiumGridServer](https://github.com/trantrungtin/AppiumGridServer) and change your address. Click run. You will see this commandline. Remember your server address.

![appium-grid-server-cmd](https://cloud.githubusercontent.com/assets/4379558/25313173/e31a814e-2853-11e7-8ab1-4420e08b8049.png)

#### Run a appium node
* Open [StartAppiumNode](https://github.com/trantrungtin/StartAppiumNode) to setup for your each appium node.
* Make sure you checked "Connect to Grid" and fill the grid server address that mentions above.
* Click "Run" to start a appium node. This tool will automatically create a node JSON file for each appium server.

![start-appium-node-screen-2](https://cloud.githubusercontent.com/assets/4379558/25313231/ff0b1b74-2854-11e7-97d1-7cf0befabc96.png)

Now this node has been registered :)

![appium-grid-server-with-node](https://cloud.githubusercontent.com/assets/4379558/25313249/4d9d65da-2855-11e7-9b3d-30646878d6ab.png)
