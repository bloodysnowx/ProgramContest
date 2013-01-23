//
//  DetailViewController.h
//  JankenMaster
//
//  Created by 岩佐 淳史 on 2012/12/26.
//  Copyright (c) 2012年 岩佐 淳史. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface DetailViewController : UIViewController

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *detailDescriptionLabel;
@end
