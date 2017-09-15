// **********************************************************************
//
// Copyright (c) 2003-2017 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

package test.Ice.adapterDeactivation;

public class Server extends test.Util.Application
{
    public int
    run(String[] args)
    {
        Ice.ObjectAdapter adapter = communicator().createObjectAdapter("TestAdapter");
        Ice.ServantLocator locator = new ServantLocatorI();

        adapter.addServantLocator(locator, "");
        adapter.activate();
        serverReady();
        adapter.waitForDeactivate();
        return 0;
    }

    protected Ice.InitializationData getInitData(Ice.StringSeqHolder argsH)
    {
        Ice.InitializationData initData = super.getInitData(argsH);
        initData.properties.setProperty("Ice.Package.Test", "test.Ice.adapterDeactivation");
        initData.properties.setProperty("TestAdapter.Endpoints", getTestEndpoint(initData.properties, 0));
        return initData;
    }

    public static void
    main(String[] args)
    {
        Server app = new Server();
        int result = app.main("Server", args);

        System.gc();
        System.exit(result);
    }
}