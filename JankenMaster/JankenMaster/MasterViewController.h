//
//  MasterViewController.h
//  JankenMaster
//
//  Created by 岩佐 淳史 on 2012/12/26.
//  Copyright (c) 2012年 岩佐 淳史. All rights reserved.
//

#import <UIKit/UIKit.h>

@class DetailViewController;

@interface MasterViewController : UITableViewController

@property (strong, nonatomic) DetailViewController *detailViewController;

@end
