//
//  JankenData.h
//  JankenMaster
//
//  Created by 岩佐 淳史 on 2012/12/26.
//  Copyright (c) 2012年 岩佐 淳史. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <CoreData/CoreData.h>


@interface JankenData : NSManagedObject

@property (nonatomic, retain) NSNumber * before;
@property (nonatomic, retain) NSNumber * next;
@property (nonatomic, retain) NSNumber * win;
@property (nonatomic, retain) NSNumber * lose;
@property (nonatomic, retain) NSNumber * tie;

@end
