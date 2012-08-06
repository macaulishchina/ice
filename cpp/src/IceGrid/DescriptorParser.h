// **********************************************************************
//
// Copyright (c) 2003-2012 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

#pragma once

namespace IceGrid
{

class DescriptorParser
{
public:

    static ApplicationDescriptor parseDescriptor(const std::string&, 
                                                 const Ice::StringSeq&, 
                                                 const std::map<std::string, std::string>&, 
                                                 const Ice::CommunicatorPtr&,
                                                 const IceGrid::AdminPrx&);

    static ApplicationDescriptor parseDescriptor(const std::string&, const Ice::CommunicatorPtr&);
    
};

}
